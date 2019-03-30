const fs = require('fs');

const regex = /^(?<type>.*)_(?<lang>Kotlin|Java|Scala)_(?<label>.*)$/;

const results = (file, jvm) => {
    const jmhResult = require(file);
    return jmhResult.map(it => {
        const benchmark = it.benchmark.substring(it.benchmark.lastIndexOf('.') + 1);
        const count = parseInt(it.params.count, 10);
        const score = it.primaryMetric.score;
        const error = it.primaryMetric.scoreError;
        const unit = it.primaryMetric.scoreUnit;

        const match = regex.exec(benchmark);
        const {type, lang, label} = match.groups;
        return {
            name: `${lang} ${label}`,
            type,
            jvm,
            lang,
            ljvm: jvm + ' ' + lang,
            label,
            count,
            score,
            error,
            unit
        };
    });
};

const result = ['11.0.2-open', '8.0.202.hs-adpt', '1.0.0-rc-12-grl']
    .map(jvm => {
        const file = `./jmh-result_${jvm}.json`;
        return results(file, jvm);
    })
    .reduce((acc, array) => ([...acc, ...array]), []);

const filterAndWrite = (filter, name) => {
    const list = result.filter(filter);
    list.sort((a, b) => b.score - a.score);
    fs.writeFileSync(`webui/src/${name}.json`, JSON.stringify(list, null, 2));
};


filterAndWrite(it => it.type === 'monteCarlo', 'monteCarlo');
filterAndWrite(it => it.type.startsWith('cfp'), 'cfp');





