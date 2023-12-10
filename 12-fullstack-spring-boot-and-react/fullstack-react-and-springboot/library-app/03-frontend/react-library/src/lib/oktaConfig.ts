export const oktaConfig = {
    clientId: "0oadqvbit5T7e5sUv5d7",
    issuer: "https://dev-91020234.okta.com/oauth2/default",
    redirectUri: "http://localhost:3000/login/callback",
    scopes: ["openid", "profile", "email"],
    pkce: true,
    disableHttpsCheck: true,
};
