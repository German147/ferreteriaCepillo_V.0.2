package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.barreragerman.fr.c.war.ferreteriaCepillo_V02.security.ApplicationUSerPermission.CLIENTE_READ;
import static com.barreragerman.fr.c.war.ferreteriaCepillo_V02.security.ApplicationUSerPermission.CLIENTE_WRITE;
import static com.barreragerman.fr.c.war.ferreteriaCepillo_V02.security.ApplicationUserRole.ADMIN;
import static com.barreragerman.fr.c.war.ferreteriaCepillo_V02.security.ApplicationUserRole.OWNER;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index","/css/*","/js/*")
                .permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/cliente").hasAnyRole(OWNER.name(),ADMIN.name())
                .antMatchers(HttpMethod.GET,"/clientes/**").hasAnyRole(OWNER.name(),ADMIN.name())
                .antMatchers(HttpMethod.POST,"/clientes/**").hasAnyRole(OWNER.name(),ADMIN.name())
                .antMatchers(HttpMethod.DELETE,"/clientes/**").hasAnyRole(OWNER.name(),ADMIN.name())
                .antMatchers(HttpMethod.PUT,"/clientes/**").hasAnyRole(OWNER.name(),ADMIN.name())
                .antMatchers(HttpMethod.GET,"/api/v2/menu").hasAnyRole(OWNER.name(),ADMIN.name())
                .antMatchers(HttpMethod.GET, "/api/v2/menu").hasAuthority(CLIENTE_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/api/**").hasAuthority(CLIENTE_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority(CLIENTE_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/api/**").hasAuthority(CLIENTE_WRITE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                 .defaultSuccessUrl("/api/v2/menu",true);
//                .and()
//                .logout()
//                .logoutUrl("/api/v2/salir")
//                .logoutRequestMatcher(new AntPathRequestMatcher("/salir","GET"))
//                .logoutSuccessUrl("/index");
//                /*.logoutSuccessUrl("/login");*/
/* .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))*/
                   // .loginPage("/api/v2/login").permitAll()
//                .defaultSuccessUrl("/api/v2/menu",true);
/*.logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))*/



    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails renzoUser = User.builder()
                .username("renzo")
                .password(passwordEncoder.encode("renzo123"))
               // .roles(ADMIN.name()) // ROLE_PATRON
                .authorities(ADMIN.getGrantedAuthority())
                .build();

        UserDetails franco = User.builder()
                .username("franco")
                .password(passwordEncoder.encode("franco01"))
               // .roles(ApplicationUserRole.OWNER.name())
                .authorities(OWNER.getGrantedAuthority())
                .build();


        return new InMemoryUserDetailsManager(
                renzoUser, franco
        );
    }
}
