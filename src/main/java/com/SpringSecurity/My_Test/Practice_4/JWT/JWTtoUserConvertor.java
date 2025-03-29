package com.SpringSecurity.My_Test.Practice_4.JWT;

import org.springframework.stereotype.Component;

@Component
public class JWTtoUserConvertor implements Converter<Jwt, UsernamePasswordAuthenticationToken> {

    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt source) {
        User user = new User();
        user.setId(source.getSubject());
        return new UsernamePasswordAuthenticationToken(user, source, Collections.EMPTY_LIST);
    }


}