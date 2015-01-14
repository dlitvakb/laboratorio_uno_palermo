PRAGMA foreign_keys = ON;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR(32),
  password VARCHAR(46),
  is_admin INTEGER
);

-- Default User
--- name: admin
--- pass: admin
INSERT INTO user (id, name, password, is_admin) VALUES (null, 'admin', '$sha1$d033e22ae348aeb5660fc2140aec35850c4da997', 1);

DROP TABLE IF EXISTS status;
CREATE TABLE status (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR(32)
);

INSERT INTO status (id, name) VALUES (null, "Open");
INSERT INTO status (id, name) VALUES (null, "In Progress");
INSERT INTO status (id, name) VALUES (null, "Done");
INSERT INTO status (id, name) VALUES (null, "Closed");

DROP TABLE IF EXISTS issue;
CREATE TABLE issue (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  user_id NOT NULL DEFAULT 1 REFERENCES user(id) ON DELETE SET DEFAULT ON UPDATE CASCADE,
  assignee_user_id REFERENCES user(id) ON DELETE SET NULL ON UPDATE CASCADE,
  name VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  status NOT NULL REFERENCES status(id) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS comment;
CREATE TABLE comment (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  user_id NOT NULL REFERENCES user(id) ON DELETE SET NULL ON UPDATE CASCADE,
  issue_id NOT NULL REFERENCES issue(id) ON DELETE CASCADE ON UPDATE CASCADE,
  content TEXT NOT NULL
);
