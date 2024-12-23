package com.interplug.reactapi.biz.config.datasource;

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
     * DB Password jasyptEncryptor 암호화 설정
     * </pre>
     * TODO: 추후 혼자 사용시 암호화 Config 설정 필요
     * @author junguKang (junguKang)
     * @ModifyDate 2024.12.13
     */
    
    /*@Bean(name = "jasyptStringEncryptor")
    public StringEncryptor jasyptStringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();



        return new org.jasypt.encryption.pbe.StandardPBEStringEncryptor();
    }*/

}
