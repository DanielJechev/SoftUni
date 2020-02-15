SELECT E.deposit_group, SUM(E.deposit_amount) AS `total_sum`
FROM wizzard_deposits AS E
WHERE E.magic_wand_creator = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group`;