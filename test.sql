/*    ==Scripting Parameters==

    Source Server Version : SQL Server 2017 (14.0.1000)
    Source Database Engine Edition : Microsoft SQL Server Express Edition
    Source Database Engine Type : Standalone SQL Server

    Target Server Version : SQL Server 2017
    Target Database Engine Edition : Microsoft SQL Server Standard Edition
    Target Database Engine Type : Standalone SQL Server
*/
USE [test]
GO
/****** Object:  Table [dbo].[departs]    Script Date: 8/14/2020 3:16:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[departs](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[records]    Script Date: 8/14/2020 3:16:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[records](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[date] [date] NULL,
	[reason] [varchar](255) NULL,
	[staff_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[staffs]    Script Date: 8/14/2020 3:16:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[staffs](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[birthday] [date] NULL,
	[name] [varchar](50) NULL,
	[photo] [varchar](100) NULL,
	[depart_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 8/14/2020 3:16:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](50) NULL,
	[password] [varchar](50) NOT NULL,
	[username] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[departs] ON 

INSERT [dbo].[departs] ([id], [name]) VALUES (1, N'Java')
INSERT [dbo].[departs] ([id], [name]) VALUES (2, N'C++')
INSERT [dbo].[departs] ([id], [name]) VALUES (3, N'php')
INSERT [dbo].[departs] ([id], [name]) VALUES (4, N'Python')
SET IDENTITY_INSERT [dbo].[departs] OFF
SET IDENTITY_INSERT [dbo].[records] ON 

INSERT [dbo].[records] ([id], [date], [reason], [staff_id]) VALUES (1, CAST(N'2020-11-02' AS Date), N'Good', 1)
SET IDENTITY_INSERT [dbo].[records] OFF
SET IDENTITY_INSERT [dbo].[staffs] ON 

INSERT [dbo].[staffs] ([id], [birthday], [name], [photo], [depart_id]) VALUES (1, CAST(N'1999-12-07' AS Date), N'Nguyen', N'Nguyen', 2)
INSERT [dbo].[staffs] ([id], [birthday], [name], [photo], [depart_id]) VALUES (3, CAST(N'2000-07-06' AS Date), N'Dang', N'a', 3)
SET IDENTITY_INSERT [dbo].[staffs] OFF
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [email], [password], [username]) VALUES (2, N'dang@gmail.com', N'123', N'dang')
SET IDENTITY_INSERT [dbo].[users] OFF
ALTER TABLE [dbo].[records]  WITH CHECK ADD  CONSTRAINT [FKh8ohht48yul18ihlwbf8em406] FOREIGN KEY([staff_id])
REFERENCES [dbo].[staffs] ([id])
GO
ALTER TABLE [dbo].[records] CHECK CONSTRAINT [FKh8ohht48yul18ihlwbf8em406]
GO
ALTER TABLE [dbo].[staffs]  WITH CHECK ADD  CONSTRAINT [FKlq1kinn71te2nigo4g4pjecvx] FOREIGN KEY([depart_id])
REFERENCES [dbo].[departs] ([id])
GO
ALTER TABLE [dbo].[staffs] CHECK CONSTRAINT [FKlq1kinn71te2nigo4g4pjecvx]
GO
