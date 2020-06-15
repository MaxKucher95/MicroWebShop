package de.hska.iwi.vslab.oauth.web;

import com.nimbusds.jose.jwk.JWKSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JwkController {

  @Autowired
	private JWKSet jwkSet;

  @GetMapping(value= "/oauth2/keys", produces= "application/json; charset=UTF-8")
  public String keys() {
    return this.jwkSet.toString();
  }
}