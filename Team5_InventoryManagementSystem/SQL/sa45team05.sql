-- MySQL Script generated by MySQL Workbench
-- Fri Dec  8 10:01:58 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sa45team05
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sa45team05` ;

-- -----------------------------------------------------
-- Schema sa45team05
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sa45team05` DEFAULT CHARACTER SET utf8 ;
USE `sa45team05` ;

-- -----------------------------------------------------
-- Table `supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supplier` (
  `supplierId` INT(11) NOT NULL AUTO_INCREMENT,
  `supplierName` VARCHAR(50) NOT NULL,
  `supplierContactNo` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`supplierId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `supplierId_UNIQUE` ON `supplier` (`supplierId` ASC);


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `userId` VARCHAR(30) NOT NULL,
  `userName` VARCHAR(50) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `userRole` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `userId_UNIQUE` ON `user` (`userId` ASC);


-- -----------------------------------------------------
-- Table `order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `order` (
  `orderId` INT(11) NOT NULL AUTO_INCREMENT,
  `orderDate` DATE NOT NULL,
  `userId` VARCHAR(30) NOT NULL,
  `supplierId` INT(11) NOT NULL,
  PRIMARY KEY (`orderId`),
  CONSTRAINT `orderSupplierId`
    FOREIGN KEY (`supplierId`)
    REFERENCES `supplier` (`supplierId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orderUserId`
    FOREIGN KEY (`userId`)
    REFERENCES `user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `orderId_UNIQUE` ON `order` (`orderId` ASC);

CREATE INDEX `userId_idx` ON `order` (`userId` ASC);

CREATE INDEX `supplierId_idx` ON `order` (`supplierId` ASC);


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `product` (
  `partNo` VARCHAR(20) NOT NULL,
  `carDealer` VARCHAR(45) NULL DEFAULT NULL,
  `partDescription` VARCHAR(80) NULL DEFAULT NULL,
  `avaliableQty` INT(11) NOT NULL,
  `color` VARCHAR(20) NULL DEFAULT NULL,
  `dimension` VARCHAR(30) NULL DEFAULT NULL,
  `reorderLevel` INT(11) NOT NULL,
  `shelfLocation` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`partNo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `PartNo_UNIQUE` ON `product` (`partNo` ASC);


-- -----------------------------------------------------
-- Table `orderdetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `orderdetail` (
  `orderId` INT(11) NOT NULL,
  `partNo` VARCHAR(20) NOT NULL,
  `transactionQty` INT(11) NOT NULL,
  PRIMARY KEY (`orderId`, `partNo`),
  CONSTRAINT `orderId`
    FOREIGN KEY (`orderId`)
    REFERENCES `order` (`orderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orderPartNo`
    FOREIGN KEY (`partNo`)
    REFERENCES `product` (`partNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `orderPartId_idx` ON `orderdetail` (`partNo` ASC);


-- -----------------------------------------------------
-- Table `productsupplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `productsupplier` (
  `partNo` VARCHAR(20) NOT NULL,
  `supplierId` INT(11) NOT NULL,
  `unitPrice` DOUBLE NOT NULL,
  `minimumReorderQty` INT(11) NOT NULL,
  PRIMARY KEY (`partNo`, `supplierId`),
  CONSTRAINT `ProductPartNo`
    FOREIGN KEY (`partNo`)
    REFERENCES `product` (`partNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ProductSupplierId`
    FOREIGN KEY (`supplierId`)
    REFERENCES `supplier` (`supplierId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `supplierId_idx` ON `productsupplier` (`supplierId` ASC);


-- -----------------------------------------------------
-- Table `return`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `return` (
  `returnId` INT(11) NOT NULL AUTO_INCREMENT,
  `partNo` VARCHAR(20) NOT NULL,
  `returnQty` INT(11) NOT NULL,
  `returnDate` DATE NOT NULL,
  PRIMARY KEY (`returnId`),
  CONSTRAINT `partNo`
    FOREIGN KEY (`partNo`)
    REFERENCES `product` (`partNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `returnId_UNIQUE` ON `return` (`returnId` ASC);

CREATE INDEX `partNo_idx` ON `return` (`partNo` ASC);


-- -----------------------------------------------------
-- Table `transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transaction` (
  `transactionId` INT(11) NOT NULL AUTO_INCREMENT,
  `transactionDate` DATE NOT NULL,
  `userId` VARCHAR(30) NOT NULL,
  `customerName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`transactionId`),
  CONSTRAINT `transactionUserId`
    FOREIGN KEY (`userId`)
    REFERENCES `user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `transactionId_UNIQUE` ON `transaction` (`transactionId` ASC);

CREATE INDEX `userId_idx` ON `transaction` (`userId` ASC);


-- -----------------------------------------------------
-- Table `transactiondetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transactiondetails` (
  `transactionId` INT(11) NOT NULL,
  `partNo` VARCHAR(20) NOT NULL,
  `transactionQty` INT(11) NOT NULL,
  PRIMARY KEY (`transactionId`, `partNo`),
  CONSTRAINT `TransactionPartNo`
    FOREIGN KEY (`partNo`)
    REFERENCES `product` (`partNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `transactionId`
    FOREIGN KEY (`transactionId`)
    REFERENCES `transaction` (`transactionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `TransactionPartNo_idx` ON `transactiondetails` (`partNo` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `supplier`
-- -----------------------------------------------------
START TRANSACTION;
USE `sa45team05`;
INSERT INTO `supplier` (`supplierId`, `supplierName`, `supplierContactNo`) VALUES (001, 'L.Mix Industries', '92341524');
INSERT INTO `supplier` (`supplierId`, `supplierName`, `supplierContactNo`) VALUES (002, 'CL Autos', '22913701');
INSERT INTO `supplier` (`supplierId`, `supplierName`, `supplierContactNo`) VALUES (003, 'Demi.L Spare Parts', '64823321');
INSERT INTO `supplier` (`supplierId`, `supplierName`, `supplierContactNo`) VALUES (004, 'David G. Service & N.M Auto Parts', '24331161');
INSERT INTO `supplier` (`supplierId`, `supplierName`, `supplierContactNo`) VALUES (005, 'Karmin Autos Accessories', '45829352');
INSERT INTO `supplier` (`supplierId`, `supplierName`, `supplierContactNo`) VALUES (006, 'Charli XCX Supplier Co.', '34455352');
INSERT INTO `supplier` (`supplierId`, `supplierName`, `supplierContactNo`) VALUES (007, 'R.Paul Autos Industries', '31981417');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `sa45team05`;
INSERT INTO `user` (`userId`, `userName`, `password`, `userRole`) VALUES ('yimonz', 'Yimon Soe', 'password', 'administrator');
INSERT INTO `user` (`userId`, `userName`, `password`, `userRole`) VALUES ('runzz23', 'Runze', 'pa55w0rd', 'mechanic');
INSERT INTO `user` (`userId`, `userName`, `password`, `userRole`) VALUES ('momozzz', 'Momo', 'momo222', 'administrator');
INSERT INTO `user` (`userId`, `userName`, `password`, `userRole`) VALUES ('kk234', 'Kiruthika', '234kk', 'mechanic');
INSERT INTO `user` (`userId`, `userName`, `password`, `userRole`) VALUES ('sunm23', 'Sun Ming', 'sming23', 'mechanic');

COMMIT;


-- -----------------------------------------------------
-- Data for table `product`
-- -----------------------------------------------------
START TRANSACTION;
USE `sa45team05`;
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('01234-01', 'Toyota', 'fender', 15, 'black', '23 (h) x 24 (w)', 10, 'B002-023');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('01234-02', 'Toyota', 'fender', 12, 'blue', '23 (h) x 24 (w)', 10, 'B002-025');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('01234-03', 'Toyota', 'fender', 10, 'yellow', '23 (h) x 24 (w) ', 10, 'B002-024');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('2345HB-SIL', 'Hyundai', 'hub cap', 23, 'silver', '4\" (d)', 15, 'C004-022');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('2345HB-BLK', 'Hyundai', 'hub cap ', 25, 'black', '4\" (d)', 15, 'C004-023');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('2458HB-SIL', 'Hyundai', 'hub cap ', 9, 'silver', '6\" (d)', 10, 'C005-025');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('2460HC-SIL', 'Hyundai', 'hub cap', 6, 'silver', '10\" (d)', 10, 'C006-034');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('21566VW-B01', 'Volkswagon', 'fender', 15, 'blue', '25 (h) x 26 (w)', 10, 'B003-025');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('02367VW-B03', 'Volkswagon', 'fender', 16, 'blue-green', '24 (h) x 24 (w)', 10, 'B002-034');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('CB03VW', 'Volkswagon', 'bumper', 12, 'silver', '25 (h) x 26 (w)', 10, 'D003-022');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('CD022VWK', 'Volkswagon', 'headlight', 5, 'clear', '21 (h) x 23 (w)', 8, 'B001-120');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('MN0234B-SIL', 'Mini Cooper', 'bumper', 10, 'silver', '25 (h) x 26 (w)', 8, 'B003-120');
INSERT INTO `product` (`partNo`, `carDealer`, `partDescription`, `avaliableQty`, `color`, `dimension`, `reorderLevel`, `shelfLocation`) VALUES ('01236MNHL', 'Mini Cooper', 'headlight', 9, 'clear', '21 (h) x 16 (w)', 10, 'B004-123');

COMMIT;


-- -----------------------------------------------------
-- Data for table `productsupplier`
-- -----------------------------------------------------
START TRANSACTION;
USE `sa45team05`;
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('01234-01', S002, 15, 15);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('01234-02', S002, 17, 15);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('01234-03', S002, 15, 15);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('01234-01', S007, 10, 25);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('01234-02', S004, 15, 20);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('01234-02', S003, 16, 16);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('2345HB-SIL', S004, 16, 15);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('2345HB-SIL', S005, 14, 18);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('2345HB-BLK', S005, 14, 18);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('2458HB-SIL', S001, 23, 10);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('2460HC-SIL', S001, 24, 15);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('21566VW-B01', S006, 56, 10);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('21566VW-B01', S007, 50, 15);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('02367VW-B03', S007, 20, 20);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('CB03VW', S006, 25, 10);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('CD022VWK', S005, 12, 15);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('MN0234B-SIL', S004, 13, 20);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('01236MNHL', S004, 20, 30);
INSERT INTO `productsupplier` (`partNo`, `supplierId`, `unitPrice`, `minimumReorderQty`) VALUES ('MN0234B-SIL', S002, 19, 50);

COMMIT;


-- -----------------------------------------------------
-- Data for table `return`
-- -----------------------------------------------------
START TRANSACTION;
USE `sa45team05`;
INSERT INTO `return` (`returnId`, `partNo`, `returnQty`, `returnDate`) VALUES (R170001, '2345HB-SIL', 2, '23/2/2017');
INSERT INTO `return` (`returnId`, `partNo`, `returnQty`, `returnDate`) VALUES (R170002, 'MN0234B-SIL', 4, '26/2/2017');

COMMIT;


-- -----------------------------------------------------
-- Data for table `transaction`
-- -----------------------------------------------------
START TRANSACTION;
USE `sa45team05`;
INSERT INTO `transaction` (`transactionId`, `transactionDate`, `userId`, `customerName`) VALUES (170001, '23/1/2017', 'runzz23', 'Mdm. Zanne');
INSERT INTO `transaction` (`transactionId`, `transactionDate`, `userId`, `customerName`) VALUES (170002, '24/1/2017', 'kk234', 'I.M.Sam');
INSERT INTO `transaction` (`transactionId`, `transactionDate`, `userId`, `customerName`) VALUES (170003, '28/2/2017', 'runzz23', 'Esma Samanda');
INSERT INTO `transaction` (`transactionId`, `transactionDate`, `userId`, `customerName`) VALUES (170004, '29/5/2017', 'sunm23', ' HRH Magical Princess');
INSERT INTO `transaction` (`transactionId`, `transactionDate`, `userId`, `customerName`) VALUES (170005, '30/7/2017', 'kk234', 'JorJor');
INSERT INTO `transaction` (`transactionId`, `transactionDate`, `userId`, `customerName`) VALUES (170006, '31/7/2017', 'sunm23', 'Edwin');

COMMIT;


-- -----------------------------------------------------
-- Data for table `transactiondetails`
-- -----------------------------------------------------
START TRANSACTION;
USE `sa45team05`;
INSERT INTO `transactiondetails` (`transactionId`, `partNo`, `transactionQty`) VALUES (170001, '01234-01', 3);
INSERT INTO `transactiondetails` (`transactionId`, `partNo`, `transactionQty`) VALUES (170001, 'MN0234B-SIL', 1);
INSERT INTO `transactiondetails` (`transactionId`, `partNo`, `transactionQty`) VALUES (170002, '01236MNHL', 2);
INSERT INTO `transactiondetails` (`transactionId`, `partNo`, `transactionQty`) VALUES (170003, '01234-01', 2);
INSERT INTO `transactiondetails` (`transactionId`, `partNo`, `transactionQty`) VALUES (170003, 'MN0234B-SIL', 3);
INSERT INTO `transactiondetails` (`transactionId`, `partNo`, `transactionQty`) VALUES (170004, 'CD022VWK', 2);
INSERT INTO `transactiondetails` (`transactionId`, `partNo`, `transactionQty`) VALUES (170005, '21566VW-B01', 1);
INSERT INTO `transactiondetails` (`transactionId`, `partNo`, `transactionQty`) VALUES (170005, '2460HC-SIL', 2);
INSERT INTO `transactiondetails` (`transactionId`, `partNo`, `transactionQty`) VALUES (170006, 'MN0234B-SIL', 3);

COMMIT;

