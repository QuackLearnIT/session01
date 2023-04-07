CREATE DATABASE FJB_04_ORM
GO

USE FJB_04_ORM
GO

SELECT * FROM [dbo].[Deparment]
GO

UPDATE Employee SET department_id = 1 WHERE id = 1

INSERT INTO [dbo].[Deparment] VALUES('Test')
INSERT INTO [dbo].[Deparment] VALUES('Test1')
INSERT INTO [dbo].[Deparment] VALUES('Test2')





SELECT d.id, COUNT(e.id) AS totalEmployee
FROM Department d
LEFT JOIN Employee e
ON d.id = e.department_id
GROUP BY d.id
