CREATE DATABASE buscaminas; 
use buscaminas;



CREATE TABLE `usuarios` (
  `nombreUsuario` varchar(20) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `nombreCompleto` varchar(20) NOT NULL,
  `rol` varchar(20) DEFAULT NULL,
  `credito` float DEFAULT '0',
  `usuarioId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`nombreUsuario`, `clave`, `nombreCompleto`, `rol`, `credito`, `usuarioId`) VALUES
('Daniel', '123', 'Daniel Cisa', 'jugador', 10, 1),
('Federico', '321', 'Federico Castrillon', 'jugador', 5, 2),
('Jorge', '123', 'Jorgito', 'administrador', 0, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuarioId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `usuarioId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
