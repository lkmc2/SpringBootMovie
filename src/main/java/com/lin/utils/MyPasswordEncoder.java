package com.lin.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security密码解析器
 * @author lkmc2
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}