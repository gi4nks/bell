package io.streamtune.bell.config;

import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurationContext;
import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurer;

public class AnalysisConfigurer implements ElasticsearchAnalysisConfigurer {

    @Override
    public void configure(ElasticsearchAnalysisConfigurationContext context) {
        context.analyzer("notes").custom()
                .tokenizer("standard")
                .tokenFilters("asciifolding", "lowercase");

        context.analyzer("labels").custom()
                .tokenizer("standard")
                .tokenFilters("asciifolding", "lowercase", "porter_stem");

        context.normalizer("sort").custom()
                .tokenFilters("asciifolding", "lowercase");
    }
}
