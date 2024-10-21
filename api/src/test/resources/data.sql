INSERT INTO Actor (first_name, last_name, email_primary, email_secondary, phone, subscription_level, node_name, node_payload, node_ts, node_uid)
VALUES
  ('John', 'Doe', 'john.doe@example.com', 'johndoe@gmail.com', '123-456-7890', 'FREE', 'Node1', '{"key": "value"}', NOW(), gen_random_uuid()),
  ('Jane', 'Smith', 'jane.smith@example.com', NULL, '234-567-8901', 'STARTER', 'Node2', '{"key": "value2"}', NOW(), gen_random_uuid()),
  ('Alice', 'Johnson', 'alice.j@example.com', 'alicej@gmail.com', '345-678-9012', 'RESEARCH', 'Node3', '{"key": "value3"}', NOW(), gen_random_uuid()),
  ('Bob', 'Brown', 'bob.brown@example.com', NULL, '456-789-0123', 'ENTERPRISE', NULL, '{}', NOW(), gen_random_uuid()),
  ('Charlie', 'Davis', 'charlie.d@example.com', 'charlied@gmail.com', '567-890-1234', 'FREE', NULL, '{"key": "value4"}', NOW(), gen_random_uuid()),
  ('David', 'Wilson', 'david.w@example.com', NULL, '678-901-2345', 'STARTER', NULL, '{}', NOW(), gen_random_uuid()),
  ('Eve', 'Martinez', 'eve.martinez@example.com', NULL, '789-012-3456', 'RESEARCH', NULL, '{}', NOW(), gen_random_uuid()),
  ('Frank','Garcia','frank.g@example.com','frankg@gmail.com','890-123-4567','ENTERPRISE','Node4','{"key":"value5"}' ,NOW(),gen_random_uuid()),
  ('Grace','Lee','grace.lee@example.com','gracelee@gmail.com','901-234-5678','FREE','Node5','{"key":"value6"}' ,NOW(),gen_random_uuid()),
  ('Hank','White','hank.w@example.com','hankw@gmail.com','012-345-6789','STARTER','Node6','{"key":"value7"}' ,NOW(),gen_random_uuid());