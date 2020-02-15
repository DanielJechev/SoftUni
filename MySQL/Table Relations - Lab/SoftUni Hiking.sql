SELECT route.`starting_point`, route.`end_point`, route.`leader_id` as leader_id, CONCAT(camper.`first_name`, ' ', camper.last_name) AS leader_name
FROM routes as route
JOIN campers AS camper on leader_id = camper.id;