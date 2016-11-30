-- CRIANDO BANCO DE DADOS
IF NOT EXISTS (SELECT 1 FROM SYS.databases WHERE name = 'BD2')
BEGIN
 CREATE DATABASE BD2
END
GO

CREATE TABLE [BD2].[dbo].[CodigoNCM](
	[CodNCM] [varchar](12) NOT NULL,
	[Descricao] [varchar](500) NOT NULL,
 CONSTRAINT [PK_CodigoNCM] PRIMARY KEY NONCLUSTERED
(
	[CodNCM] ASC
)
)
GO

CREATE TABLE [BD2].[dbo].[Produtos](
	[CodProduto] [int] NOT NULL,
	[Descricao] [varchar](50) NULL,
	[CodEAN] [varchar](14) NULL,
	[NumRegMS] [varchar](20) NULL,
	[CodNCM] [varchar](12) NULL,
	[PrcFabricante] [numeric](18, 4) NULL,
	[PrcVenda] [numeric](18, 4) NULL,
 CONSTRAINT [PK_Produtos] PRIMARY KEY NONCLUSTERED
(
	[CodProduto] ASC
)
)
GO

ALTER TABLE [BD2].[dbo].[Produtos]  WITH NOCHECK ADD  CONSTRAINT [FK_Produto_CodigoNCM] FOREIGN KEY([CodNCM])
REFERENCES [BD2].[dbo].[CodigoNCM] ([CodNCM])
NOT FOR REPLICATION
GO

ALTER TABLE [BD2].[dbo].[Produtos] CHECK CONSTRAINT [FK_Produto_CodigoNCM]
GO