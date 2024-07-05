package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.admin_portal.auth.AuthToken;
import com.zalominimenu.springboot.dto.customer_portal.GetTokenRequest;
import com.zalominimenu.springboot.security.jwt.JwtTokenService;
import com.zalominimenu.springboot.utils.CustomResponseEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/customer-portal/auth")
@Slf4j
public class CustomerAuthController {
    private final JwtTokenService jwtTokenService;

    @PostMapping("/get-token")
    public ResponseEntity<BaseResponse<AuthToken>> getToken(@Valid @RequestBody GetTokenRequest req) {
        final AuthToken token = jwtTokenService.getAuthTokenFromZaloPhoneTokenAndAccessToken(req);

        return CustomResponseEntity.ok(token, "Xác thực thành công");
    }
}
