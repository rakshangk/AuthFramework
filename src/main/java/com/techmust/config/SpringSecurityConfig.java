
package com.techmust.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
    private DataSource m_oDataSource;
	
	  
	@Override
	 protected void configure(HttpSecurity oHttpSecurity) throws Exception
    {
		oHttpSecurity.httpBasic().and().authorizeRequests()
        .antMatchers("/signIn", "/user").hasRole("USER").and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .sessionFixation().none().and()
        .csrf().disable().headers().frameOptions().disable();
        // Config Remember Me.
		oHttpSecurity.authorizeRequests().and() 
        .rememberMe().tokenRepository(this.persistentTokenRepository())
        .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
    } 

	@Bean
	public PersistentTokenRepository persistentTokenRepository()
	{
		JdbcTokenRepositoryImpl oJdbcTokenRepository = new JdbcTokenRepositoryImpl();
		oJdbcTokenRepository.setDataSource(m_oDataSource);
		return oJdbcTokenRepository;
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder oAuthenticationManagerBuilder) throws Exception 
	{
		oAuthenticationManagerBuilder.jdbcAuthentication().dataSource(m_oDataSource);
	}	
}