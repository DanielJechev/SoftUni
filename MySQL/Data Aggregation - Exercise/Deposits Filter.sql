SELECT E.deposit_group, SUM(E.deposit_amount) AS `total_sum`
FROM wizzard_deposits AS E
WHERE E.magic_wand_creator = 'Ollivander family'
GROUP BY E.deposit_group
HAVING SUM(deposit_amount) < 150000
ORDER BY total_sum DESC;