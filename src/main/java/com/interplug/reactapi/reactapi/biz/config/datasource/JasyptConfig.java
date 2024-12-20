package com.interplug.reactapi.reactapi.biz.config.datasource;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    private static final String KEY = "<PASSWORD>";
    private static final String ALGORITHM = "PBEWithMD5AndDES";

    /**
     *
     *
     * <pre>
     * jasyptEncryptor 설정
     * </pre>
     *
     * @author junguKang
     * @return StringEncryptor
     */
    /*@Bean(name = "jasyptStringEncryptor")
    public StringEncryptor jasyptStringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();



        return new org.jasypt.encryption.pbe.StandardPBEStringEncryptor();
    }*/

}
