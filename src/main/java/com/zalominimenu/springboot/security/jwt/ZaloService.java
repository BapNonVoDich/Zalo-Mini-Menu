package com.zalominimenu.springboot.security.jwt;

import com.zalominimenu.springboot.dto.customer_portal.ZaloUserPhoneNumberData;
import com.zalominimenu.springboot.dto.customer_portal.ZaloUserPhoneNumberFromAccessToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class ZaloService {
    private final WebClient webClient = WebClient.create();

    public String getUserPhoneNumberFromToken(String accessToken, String phoneNumberToken) {
        // TODO: Move var to properties
        ZaloUserPhoneNumberFromAccessToken zup = webClient.get()
                .uri("https://graph.zalo.me/v2.0/me/info")
                .header("access_token",accessToken)
                .header("code",phoneNumberToken)
                .header("secret_key","k9oJIBKfBQX6QVkbcd45")
                .retrieve()
                .bodyToMono(ZaloUserPhoneNumberFromAccessToken.class)
                .block();

        ZaloUserPhoneNumberData zupData = zup.getData();

        if (zupData == null) {
            log.error("Error getting phone number from Zalo: {}, {}", zup.getError(), zup.getMessage());
            return null;
        }

        log.info("Got phone number from Zalo: {}", zupData.getNumber());

        return zupData.getNumber();
    }
}
