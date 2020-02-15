SELECT SUM(diff.next)
FROM (
         SELECT `deposit_amount` -
                (SELECT `deposit_amount`
                 FROM wizzard_deposits
                 WHERE `id` = wd.id + 1) AS `next`
         FROM `wizzard_deposits` AS `wd`
     ) AS `diff`