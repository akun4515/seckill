package cn.dface;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by akun on 2017/7/11.
 */
@Configuration
@EnableBatchProcessing
public class CsvBatchConfig {

    @Bean
    public ItemReader<Person> reader(){
        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("people.csv"));
        reader.setLineMapper(new DefaultLineMapper<Person>(){
            @Override
            public void setLineTokenizer(LineTokenizer tokenizer) {
                super.setLineTokenizer(tokenizer);
            }

            @Override
            public void setFieldSetMapper(FieldSetMapper<Person> fieldSetMapper) {
                super.setFieldSetMapper(fieldSetMapper);
            }

        });

    }

}
