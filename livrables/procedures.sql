DROP PROCEDURE IF EXISTS `findLorannPosition`;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findLorannPosition` (IN `level` INT)  NO SQL
SELECT x,y FROM characters WHERE idLevel = level AND characters.Character = "Lorann";

DROP PROCEDURE IF EXISTS `findMonster1Position`;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findMonster1Position` (IN `level` INT)  NO SQL
SELECT x,y FROM characters WHERE idLevel = level AND characters.Character = "Monster1";

DROP PROCEDURE IF EXISTS `findMonster2Position`;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findMonster2Position` (IN `level` INT)  NO SQL
SELECT x,y FROM characters WHERE idLevel = level AND characters.Character = "Monster2";

DROP PROCEDURE IF EXISTS `findMonster3Position`;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findMonster3Position` (IN `level` INT)  NO SQL
SELECT x,y FROM characters WHERE idLevel = level AND characters.Character = "Monster3";

DROP PROCEDURE IF EXISTS `findMonster4Position`;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findMonster4Position` (IN `level` INT)  NO SQL
SELECT x,y FROM characters WHERE idLevel = level AND characters.Character = "Monster4";

DROP PROCEDURE IF EXISTS `findSpriteByName`;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findSpriteByName` (IN `def` TEXT)  NO SQL
SELECT sprite
FROM sprites
WHERE sprites.def = def;