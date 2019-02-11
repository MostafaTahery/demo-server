INSERT INTO oauth2jdbc.oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove)
VALUES
    ("fooClientIdPassword", "secret", "foo,read,write","password,authorization_code,refresh_token", null, null, 36000, 36000, null, true);

insert into oauth2jdbc.oauth_client_users
(username, password, client_id,roles)
values
("ali","gholi","fooClientIdPassword","USER");

insert into oauth2jdbc.oauth_client_users
(username, password, client_id,roles)
values
("borzo","bagheri","fooClientIdPassword","ADMIN");

insert into oauth2jdbc.oauth_client_users
(username, password, client_id,roles)
values
("carmen","electra","fooClientIdPassword","USER,ADMIN");