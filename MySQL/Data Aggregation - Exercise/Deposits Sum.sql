SELECT E.`deposit_group`, SUM(E.`deposit_amount`) AS `total_sum`FROM wizzard_deposits AS E
GROUP BY deposit_group
ORDER BY SUM(E.deposit_amount);