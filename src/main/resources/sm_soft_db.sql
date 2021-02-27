DROP TABLE IF EXISTS sm_user_action;

CREATE TABLE sm_user_action (
    id int not null AUTO_INCREMENT,
    ssoid varchar(100) not null,
    ts int not null,
    grp varchar(100),
    type varchar(100),
    subtype varchar(100),
    url varchar(255),
    orgid varchar(100),
    formid varchar(100),
    code varchar(100),
    ltpa varchar(100),
    sudirresponse varchar(255),
    ymdh datetime not null,

    PRIMARY KEY (id)
);

CREATE VIEW sm_top_five_forms AS
SELECT
    row_number() OVER (ORDER BY count(sm_user_action.formid) DESC) id,
    formid, url, orgid, COUNT(formid) count
FROM
    sm_user_action
GROUP BY formid
ORDER BY count DESC
LIMIT 5;