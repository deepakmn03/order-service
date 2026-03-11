-- Insert 10 users
INSERT INTO users (username, email, password, address) VALUES
('john_doe', 'john@example.com', 'pass123', '123 Main St'),
('jane_smith', 'jane@example.com', 'pass456', '456 Oak Ave'),
('mike_johnson', 'mike@example.com', 'pass789', '789 Pine Rd'),
('sarah_williams', 'sarah@example.com', 'pass101', '101 Elm St'),
('david_brown', 'david@example.com', 'pass202', '202 Maple Dr'),
('emily_davis', 'emily@example.com', 'pass303', '303 Cedar Ln'),
('james_miller', 'james@example.com', 'pass404', '404 Birch Way'),
('lisa_wilson', 'lisa@example.com', 'pass505', '505 Spruce Ct'),
('robert_moore', 'robert@example.com', 'pass606', '606 Ash Pl'),
('mary_taylor', 'mary@example.com', 'pass707', '707 Walnut St');

-- Insert orders for users
INSERT INTO orders (order_value, user_id) VALUES
(5000, 1), (7500, 1), (3200, 1),
(9500, 2), (4200, 2),
(6800, 3), (5500, 3), (8200, 3),
(12000, 4), (3500, 4),
(7200, 5),
(4900, 6), (6100, 6), (5300, 6),
(8900, 7), (6700, 7),
(5600, 8), (7100, 8),
(9200, 9), (4400, 9), (6600, 9),
(11000, 10);
