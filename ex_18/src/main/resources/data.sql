INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES('JAN 26', 'REPUBLIC DAY', 'FEDERAL', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES('MAR 8', 'HOLI', 'FESTIVAL', CURDATE(), 'DBA');

INSERT INTO `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES('AUG 15', 'INDEPENDENCE DAY', 'FEDERAL', CURDATE(), 'DBA');


INSERT INTO `roles` (`role_name`, `created_at`, `created_by`)
VALUES('ADMIN', CURDATE(), 'DBA')

INSERT INTO `roles` (`role_name`, `created_at`, `created_by`)
VALUES('STUDENT', CURDATE(), 'DBA')