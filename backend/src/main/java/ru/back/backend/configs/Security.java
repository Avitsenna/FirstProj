package ru.back.backend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import ru.back.backend.model.RolesForUsers;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").hasAnyAuthority("user:write")
                .antMatchers("/auth/login/**").anonymous()
                .and()// отсюда: конкатинация действий
                .formLogin()
                .loginPage("/auth/login")//страничка для входа
                .defaultSuccessUrl("/feed")//после входа
                .and()
                .rememberMe()//запомнить меня,не заполнять данные каждый раз
                .and()
                //все, связанное с выходом
                .logout()
                .logoutUrl("/logout")//перенаправление на страничку для выхода
                .clearAuthentication(true)//после выхода убрать аутентификацию
                .invalidateHttpSession(true)//сделать нынешнюю сессию недействительной
                .deleteCookies("JSESSIONID", "remember-me")//удаление куки по сессии и функции "запомнить меня"
                .logoutSuccessUrl("/auth/login");//главная страничка входа, после выхода

    }
    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                //тестовый АДМИН
                User.builder()
                        .username("Admin")
                        .password(passwordEncoder().encode("Admin"))
                        .authorities(RolesForUsers.ADMIN.getAuthorities())
                        .build(),
                //тестовый ЮЗЕР
                User.builder()
                        .username("Username")
                        .password(passwordEncoder().encode("password"))
                        .authorities(RolesForUsers.USER.getAuthorities())
                        .build()
        );
    }
}
