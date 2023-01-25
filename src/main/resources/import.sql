-- the order of values is related to the name of field.
-- Updating is necessary, if the name is changed



-- ----------------------------
-- Table structure for product_category

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO "public"."product_category" VALUES (2147483641, 'Cars', 0, '2018-03-09 23:03:26', '2023-01-10 00:15:27');
INSERT INTO "public"."product_category" VALUES (2147483642, 'Planes', 2, '2018-03-10 00:15:02', '2023-01-10 00:15:21');
INSERT INTO "public"."product_category" VALUES (2147483644, 'Rockets', 3, '2018-03-10 01:01:09', '2023-01-10 01:01:09');
INSERT INTO "public"."product_category" VALUES (2147483645, 'Ships', 1, '2018-03-10 00:26:05', '2023-01-10 00:26:05');


-- ----------------------------
-- Records of product_in_order
-- ----------------------------

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO "public"."product_info" VALUES ('B0003', 0, '2023-01-10 10:37:39', 'Car 1940s', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/car3done.png', 'Car 1940s', 150000.00, 0, 200, '2023-01-10 19:42:02');
INSERT INTO "public"."product_info" VALUES ('C0003', 2, '2023-01-10 12:12:46', 'Plane-X', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/plane3done.png', 'Plane-X', 180000000.00, 0, 222, '2023-01-10 12:12:46');
INSERT INTO "public"."product_info" VALUES ('D0001', 3, '2023-03-10 06:51:03', 'Model 3000', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/ship1done.png', 'Model 3000', 6881888.00, 0, 100, '2023-01-10 12:04:13');
INSERT INTO "public"."product_info" VALUES ('B0002', 0, '2023-01-11 10:35:43', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/car2done.png', 'Car 1800s', 510000.00, 0, 195, '2023-01-11 10:35:43');
INSERT INTO "public"."product_info" VALUES ('C0001', 2, '2023-01-10 12:09:41', 'Plane-1 Super', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/plane1done.png', 'Plane-1 Super', 58888888.00, 0, 109, '2023-01-11 12:09:41');
INSERT INTO "public"."product_info" VALUES ('C0002', 2, '2023-01-10 12:11:51', 'Plane-2 Super', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/plane2done.jpg', 'Plane-2 Super', 68581818.00, 0, 108, '2023-01-11 12:11:51');
INSERT INTO "public"."product_info" VALUES ('B0001', 0, '2023-01-10 06:44:25', 'Car 1900s', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/car1done.png', 'Car 1900s', 280000.00, 0, 96, '2023-01-10 06:44:25');
INSERT INTO "public"."product_info" VALUES ('B0004', 0, '2023-01-10 10:39:29', 'Car 1940s', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/car4done.png', 'Car 1940s', 350000.00, 0, 199, '2023-01-10 10:39:32');
INSERT INTO "public"."product_info" VALUES ('B0005', 0, '2023-01-10 10:40:35', 'Car 1950s', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/car5done.png', 'Car 1950s', 188888.00, 0, 199, '2023-01-10 10:40:35');
INSERT INTO "public"."product_info" VALUES ('D0002', 3, '2023-01-10 12:08:17', 'Ship Awesome', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/ship2done.png', 'Ship Awesome', 5665515.00, 0, 200, '2023-01-10 12:08:17');
INSERT INTO "public"."product_info" VALUES ('F0001', 1, '2023-01-10 12:15:05', 'Rocket space', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/rock1done.png', 'Rocket space', 5818880000.00, 0, 57, '2023-01-10 12:15:10');
INSERT INTO "public"."product_info" VALUES ('F0002', 1, '2023-03-10 12:16:44', 'Rocket Old Fashion', 'https://aws-codestar-us-east-2-923353282806-icrystal-app.s3.us-east-2.amazonaws.com/public/ranshopimage/rocket2done.png', 'Rocket Old Fashion', 5100000000.00, 0, 22, '2023-03-10 12:16:44');


-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO "public"."users" VALUES (2147483641, 't', '555 Goodman Rd.', 'customer1@email.com', 'Mr.Goodman', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '(512)356-1778', 'ROLE_CUSTOMER');
INSERT INTO "public"."users" VALUES (2147483642, 't', '222 CEO St.', 'manager1@email.com', 'Dr.CEO', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '(959)355-6677)', 'ROLE_MANAGER');
INSERT INTO "public"."users" VALUES (2147483643, 't', '188 Manager Blvd.', 'employee1@email.com', 'Mrs.Manager', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '(211)885-5151', 'ROLE_EMPLOYEE');
INSERT INTO "public"."users" VALUES (2147483645, 't', '188 Business Cove', 'customer2@email.com', 'Crazy Buyer', '$2a$10$0oho5eUbDqKrLH026A2YXuCGnpq07xJpuG/Qu.PYb1VCvi2VMXWNi', '(555)151-0055', 'ROLE_CUSTOMER');

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO "public"."cart" VALUES (2147483641);
INSERT INTO "public"."cart" VALUES (2147483642);
INSERT INTO "public"."cart" VALUES (2147483643);
INSERT INTO "public"."cart" VALUES (2147483645);


