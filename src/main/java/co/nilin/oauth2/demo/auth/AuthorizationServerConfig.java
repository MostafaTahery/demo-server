package co.nilin.oauth2.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.sql.DataSource;


@EnableAuthorizationServer
@PropertySource({"classpath:db.properties"})
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("db.class.name"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;

    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(NoOpPasswordEncoder.getInstance())
                .checkTokenAccess("permitAll()")
                .tokenKeyAccess("permitAll()")
        .allowFormAuthenticationForClients();
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /*clients.inMemory()
                .withClient("guest_api")
                .scopes("READ_ALL_GUESTS","WRITE_GUEST","UPDATE_GUEST")
                .secret("secret")
                .authorities("ROLE_GUEST_AUTHORIZED_CLIENT")
                .autoApprove(true)
                .authorizedGrantTypes("client_credentials")
                .and()
                .withClient("api_audit")
                .scopes("READ_ALL_GUESTS")
                .secret("secret")
                .autoApprove(true)
                .authorities("ROLE_GUESTS_AUTHORIZED_CLIENT")
                .authorizedGrantTypes("client_credentials");*/
            clients.jdbc(dataSource());
                    //.withClient("foo")
                    //.authorizedGrantTypes("client_credentials")
                    //.authorities("read,write")
                    //.secret("secret")
                    //.scopes("read,write")
                    //.autoApprove(true);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(new InMemoryTokenStore());
    }


}
