package co.nilin.oauth2.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;


@EnableAuthorizationServer
@RestController
@PropertySource({"classpath:db.properties"})
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private Environment env;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.class.name"));
        dataSource.setUrl(env.getProperty("db.url"));
        //dataSource.setSchema("oauth2jdbc");
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));

        return dataSource;

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(passwordEncoder())
                .checkTokenAccess("permitAll()")
                .tokenKeyAccess("permitAll()")
        .allowFormAuthenticationForClients();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
       return NoOpPasswordEncoder.getInstance();
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
                    /*.withClient("foo")
                    .authorizedGrantTypes("client_credentials")
                    .authorities("read,write")
                    .secret("secret")
                    .scopes("read,write")
                    .autoApprove(true);*/

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

       /* CompositeTokenGranter tokenGranter;
        ResourceOwnerPasswordTokenGranter roptg=new ResourceOwnerPasswordTokenGranter();
        List<TokenGranter> tokenGranters = (List<TokenGranter>) endpoints.getTokenGranter();
        tokenGranters.add()// implementation up to you
        tokenGranter = new CompositeTokenGranter(tokenGranters);
        endpoints.tokenGranter(tokenGranter);*/
        endpoints.tokenStore(new InMemoryTokenStore())
                    .authenticationManager(authenticationManager);
    }



}
