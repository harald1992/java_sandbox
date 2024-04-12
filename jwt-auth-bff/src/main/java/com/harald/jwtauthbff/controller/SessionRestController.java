// package com.harald.jwtauthbff.controller;
//
// import com.harald.jwtauthbff.entity.SessionEntity;
// import com.harald.jwtauthbff.repository.SessionRepository;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// import java.util.List;
//
// import static com.harald.jwtauthbff.constants.EndpointConstants.API_SESSION_URL;
//
// @RestController
// @RequestMapping(API_SESSION_URL)
// public class SessionRestController {
//
//     private final SessionRepository sessionRepository;
//
//     public SessionRestController(final SessionRepository sessionRepository) {
//         this.sessionRepository = sessionRepository;
//     }
//
//     @GetMapping()
//     // public ResponseEntity<List<SessionEntity>> test(Principal principal, HttpSession session,
//     //                                                 @CookieValue(name = "login-cookie") String loginCookie) {
//     public ResponseEntity<List<SessionEntity>> getSessions() {
//
//         List<SessionEntity> list = sessionRepository.findAll();
//
//         return ResponseEntity.ok(list);
//     }
//
// }
