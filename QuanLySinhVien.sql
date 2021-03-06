USE [master]
GO
/****** Object:  Database [QuanLySinhVien]    Script Date: 6/5/2021 1:10:25 AM ******/
CREATE DATABASE [QuanLySinhVien]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLySinhVien', FILENAME = N'D:\SQL Server 2019\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLySinhVien.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLySinhVien_log', FILENAME = N'D:\SQL Server 2019\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLySinhVien_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLySinhVien] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLySinhVien].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLySinhVien] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLySinhVien] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLySinhVien] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLySinhVien] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLySinhVien] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLySinhVien] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLySinhVien] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLySinhVien] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLySinhVien] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLySinhVien] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLySinhVien] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLySinhVien] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLySinhVien] SET QUERY_STORE = OFF
GO
USE [QuanLySinhVien]
GO
/****** Object:  Table [dbo].[Diem]    Script Date: 6/5/2021 1:10:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Diem](
	[Mamon] [varchar](10) NOT NULL,
	[Tenmon] [varchar](50) NOT NULL,
	[Sotinchi] [int] NOT NULL,
	[Diemso] [float] NULL,
	[Namhoc] [varchar](10) NOT NULL,
	[Hocki] [varchar](10) NOT NULL,
	[MSSV] [varchar](10) NOT NULL,
 CONSTRAINT [PK_DiemSo] PRIMARY KEY CLUSTERED 
(
	[Mamon] ASC,
	[MSSV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Namhoc_Hocki]    Script Date: 6/5/2021 1:10:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Namhoc_Hocki](
	[Namhoc] [varchar](20) NOT NULL,
	[Hocki] [varchar](10) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 6/5/2021 1:10:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SinhVien](
	[MSSV] [varchar](10) NOT NULL,
	[Hoten] [varchar](30) NOT NULL,
	[Gioitinh] [varchar](10) NOT NULL,
	[Ngaysinh] [date] NOT NULL,
	[Quequan] [varchar](20) NOT NULL,
	[Nganh] [varchar](50) NOT NULL,
	[Khoa] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 6/5/2021 1:10:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MSGV] [varchar](10) NOT NULL,
	[Matkhau] [varchar](20) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[MSGV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT101', N'Lap trinh can ban A', 4, 8, N'2018-2019', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT112', N'Mang may tinh', 3, 8.1, N'2020-2021', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT172', N'Toan roi rac', 4, 7, N'2018-2019', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT174', N'Phan tich va thiet ke thuat toan', 3, 7.3, N'2019-2020', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT175', N'Ly thuyet do thi', 3, 7.2, N'2020-2021', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT176', N'Lap trinh huong doi tuong', 3, 7.5, N'2019-2020', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT178', N'Nguyen li he dieu hanh', 3, 7.5, N'2019-2020', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT180', N'Co so du lieu', 3, 8, N'2019-2020', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT182', N'Ngon ngu mo hinh hoa', 3, 8.4, N'2019-2020', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT183', N'Anh van chuyen Cong nghe Thong tin 1', 3, 7, N'2020-2021', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT184', N'Anh van chuyen Cong nghe Thong tin 2', 3, -1, N'2020-2021', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT205', N'Quan tri co so du lieu', 3, 9, N'2020-2021', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT240', N'Nguyen li xay dung phan mem', 3, -1, N'2020-2021', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT241', N'Phan tich yeu cau phan mem', 3, -1, N'2020-2021', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT246', N'Lap trinh .NET', 3, 4, N'2020-2021', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT276', N'Lap trinh Java', 3, -1, N'2020-2021', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'CT428', N'Lap trinh Web', 3, -1, N'2020-2021', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'KL001', N'Phap luat dai cuong', 2, 8, N'2018-2019', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'KL001', N'Phap luat dai cuong', 2, 7.4, N'2018-2019', N'1', N'B1905025')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'ML006', N'Tu tuong Ho Chi Minh', 2, 8.7, N'2019-2020', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'ML006', N'Tu tuong Ho Chi Minh', 2, 7.6, N'2018-2019', N'1', N'B1805999')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'ML006', N'Tu tuong Ho Chi Minh', 2, 8.7, N'2019-2020', N'1', N'B1905025')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'ML009', N'Nhung nguyen li co ban cua chu nghia Mac-Lenin 1', 2, 7, N'2018-2019', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'ML010', N'Nhung nguyen li co ban cua chu nghia Mac-Lenin 2', 3, 9, N'2018-2019', N'hè', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'ML011', N'Duong loi cach mang cua Dang cong san Viet Nam', 3, 8, N'2019-2020', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'QP006', N'Giao duc quoc phong va an ninh 1', 2, 9, N'2019-2020', N'hè', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'QP007', N'Giao duc quoc phong va an ninh 2', 2, 8.4, N'2019-2020', N'hè', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'QP008', N'Giao duc quoc phong va an ninh 3', 3, 8.7, N'2019-2020', N'hè', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'QP009', N'Giao duc quoc phong va an ninh 4', 1, 7.4, N'2019-2020', N'hè', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TC025', N'Co vua 1', 1, 9, N'2018-2019', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TC025', N'Co vua 1', 1, 9, N'2018-2019', N'1', N'B1805999')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TC026', N'Co vua 2', 1, 8, N'2019-2020', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN001', N'Vi - Tich phan A1', 3, 6, N'2018-2019', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN001', N'Vi tich phan A1', 3, 7, N'2018-2019', N'1', N'B1805999')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN001', N'Vi - Tich phan A1', 3, 6.8, N'2018-2019', N'1', N'B1905025')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN002', N'Vi - Tich phan A2', 4, 7.4, N'2019-2020', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN010', N'Xac xuat thong ke', 3, 8, N'2018-2019', N'hè', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN012', N'Dai so tuyen tinh va Hinh hoc', 4, 4, N'2018-2019', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN033', N'Tin hoc can ban ', 1, 7.7, N'2018-2019', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN033', N'Tin hoc can ban ', 1, 6.8, N'2018-2019', N'1', N'B1805999')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN033', N'Tin hoc can ban ', 1, 5.3, N'2018-2019', N'1', N'B1905025')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN034', N'TT Tin hoc can ban', 2, 9, N'2018-2019', N'1', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN034', N'TT Tin hoc can ban', 2, 9, N'2018-2019', N'1', N'B1805999')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TN034', N'TT Tin hoc can ban', 2, 7, N'2018-2019', N'1', N'B1905025')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'TV027', N'Co vua 3', 1, 8, N'2019-2020', N'2', N'B1805000')
INSERT [dbo].[Diem] ([Mamon], [Tenmon], [Sotinchi], [Diemso], [Namhoc], [Hocki], [MSSV]) VALUES (N'XH011', N'Co so van hoc Viet Nam', 2, 9, N'2018-2019', N'1', N'B1805000')
GO
INSERT [dbo].[Namhoc_Hocki] ([Namhoc], [Hocki]) VALUES (N'2018-2019           ', N'1         ')
INSERT [dbo].[Namhoc_Hocki] ([Namhoc], [Hocki]) VALUES (N'2018-2019           ', N'2         ')
INSERT [dbo].[Namhoc_Hocki] ([Namhoc], [Hocki]) VALUES (N'2018-2019           ', N'hè        ')
INSERT [dbo].[Namhoc_Hocki] ([Namhoc], [Hocki]) VALUES (N'2019-2020           ', N'1         ')
INSERT [dbo].[Namhoc_Hocki] ([Namhoc], [Hocki]) VALUES (N'2019-2020           ', N'2         ')
INSERT [dbo].[Namhoc_Hocki] ([Namhoc], [Hocki]) VALUES (N'2019-2020           ', N'hè        ')
INSERT [dbo].[Namhoc_Hocki] ([Namhoc], [Hocki]) VALUES (N'2020-2021           ', N'1         ')
INSERT [dbo].[Namhoc_Hocki] ([Namhoc], [Hocki]) VALUES (N'2020-2021           ', N'2         ')
INSERT [dbo].[Namhoc_Hocki] ([Namhoc], [Hocki]) VALUES (N'2020-2021           ', N'hè        ')
GO
INSERT [dbo].[SinhVien] ([MSSV], [Hoten], [Gioitinh], [Ngaysinh], [Quequan], [Nganh], [Khoa]) VALUES (N'B1805000', N'Nguyen Minh Hai', N'Nam', CAST(N'2000-04-05' AS Date), N'Ca Mau', N'Cong nghe Thong tin', 44)
INSERT [dbo].[SinhVien] ([MSSV], [Hoten], [Gioitinh], [Ngaysinh], [Quequan], [Nganh], [Khoa]) VALUES (N'B1805999', N'Tran Thi Lien', N'Nu', CAST(N'2000-12-09' AS Date), N'Vinh Long', N'Cong nghe Thong tin', 44)
INSERT [dbo].[SinhVien] ([MSSV], [Hoten], [Gioitinh], [Ngaysinh], [Quequan], [Nganh], [Khoa]) VALUES (N'B1905025', N'Le Van Long', N'Nam', CAST(N'2001-04-16' AS Date), N'An Giang', N'Ky thuat Phan mem', 45)
GO
INSERT [dbo].[TaiKhoan] ([MSGV], [Matkhau]) VALUES (N'GV001', N'123456')
INSERT [dbo].[TaiKhoan] ([MSGV], [Matkhau]) VALUES (N'GV002', N'123456')
INSERT [dbo].[TaiKhoan] ([MSGV], [Matkhau]) VALUES (N'GV003', N'12346')
GO
USE [master]
GO
ALTER DATABASE [QuanLySinhVien] SET  READ_WRITE 
GO
