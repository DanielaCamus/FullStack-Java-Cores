USE clientesypedidos;

-- Inserta al menos cinco nuevos clientes en la tabla clientes
INSERT INTO clientes (nombre, direccion, telefono) VALUES 
('Fernando Aravena', 'Av. Tobalaba 12000, Peñalolén', '+56987654321'),
('Valentina Rojas', 'Av. Grecia 8000, Peñalolén', '+56912345678'),
('David Castillo', 'Consistorial 2500, Peñalolén', '+56955667788'),
('Diego Soto', 'Av. Irarrazaval 3000, Ñuñoa', '+56911223344'),
('Camila Silva', 'Av. Ossa 400, La Reina', '+56999887766');

-- Inserta al menos diez nuevos pedidos en la tabla pedidos asociados a los clientes
INSERT INTO pedidos (fecha, total, cliente_id) VALUES 
('2026-01-02', 45990.00, 1),
('2026-01-03', 15000.50, 2),
('2026-02-04', 89000.00, 1),
('2026-02-06', 125000.00, 4),
('2026-03-09', 34000.90, 3),
('2026-04-11', 5500.00, 5),
('2026-05-13', 12000.00, 3),
('2026-05-14', 8500.00, 2),
('2026-06-15', 7650.00, 4),
('2026-06-16', 22400.00, 2);

-- Proyectar TODOS los clientes de la tabla clientes y sus respectivos pedidos
SELECT	clientes.id AS cliente_id, 
		clientes.nombre, 
		pedidos.id AS pedido_id, 
		pedidos.fecha, 
		pedidos.total
FROM clientes LEFT JOIN pedidos ON clientes.id = pedidos.cliente_id;

-- Proyecta todos los pedidos realizados por un cliente específico, utilizando su ID
SELECT	clientes.nombre, 
		pedidos.id AS pedido_id, 
		pedidos.fecha, 
		pedidos.total
FROM clientes INNER JOIN pedidos ON clientes.id = pedidos.cliente_id
WHERE clientes.id = 2;

-- Calcula el total de todos los pedidos para cada cliente.
SELECT	clientes.id AS cliente_id,
		clientes.nombre, 
		SUM(pedidos.total) AS suma_total
FROM clientes INNER JOIN pedidos ON clientes.id = pedidos.cliente_id
GROUP BY clientes.id, clientes.nombre;

-- Elimina un cliente específico de la tabla clientes y todos sus pedidos asociados de la tabla pedidos
DELETE FROM pedidos 
WHERE cliente_id = 5;

DELETE FROM clientes 
WHERE id = 5;

-- Proyecta los tres clientes que han realizado más pedidos, ordenados de forma descendente por el número de pedidos.
SELECT	clientes.id AS cliente_id, 
		clientes.nombre, 
		COUNT(pedidos.id) AS cantidad_de_pedidos
FROM clientes INNER JOIN pedidos ON clientes.id = pedidos.cliente_id
GROUP BY clientes.id, clientes.nombre
ORDER BY cantidad_de_pedidos DESC
LIMIT 3;






