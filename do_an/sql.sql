CREATE DATABASE QL_banhang_DoUong;
GO
USE QL_banhang_DoUong;
GO
CREATE LOGIN QL_banhang_DoUong WITH PASSWORD = '123456';
GO
CREATE USER QL_banhang_DoUong FOR LOGIN QL_banhang_DoUong;
GO
ALTER ROLE db_owner ADD MEMBER QL_banhang_DoUong;
GO

-- 1. tạo tài khoản và sử dụng tài khoản(tài khoản)
CREATE TABLE TaiKhoan (
    TenDangNhap VARCHAR(50) PRIMARY KEY,
    MatKhau VARCHAR(100) NOT NULL,
    HoTen NVARCHAR(100) NOT NULL,
    VaiTro NVARCHAR(30) NOT NULL
);
GO
INSERT INTO TaiKhoan VALUES ('admin', '123456', N'Quản trị', N'Admin');
GO

-- 2. Tạo bảng Sản Phẩm (Đồ uống)
CREATE TABLE SanPham (
    MaSP VARCHAR(10) PRIMARY KEY,
    TenSP NVARCHAR(100) NOT NULL,
    DonGia FLOAT NOT NULL,
    SoLuong INT NOT NULL
);
GO

-- 3. Tạo bảng Hóa Đơn (Lưu lịch sử đặt hàng khi bấm Thanh toán)
CREATE TABLE HoaDon (
    MaHD VARCHAR(15) PRIMARY KEY,
    NgayLap DATETIME DEFAULT GETDATE(),
    TongTien FLOAT NOT NULL
);
GO

-- 4. Tạo bảng Chi Tiết Hóa Đơn
CREATE TABLE ChiTietHoaDon (
    MaHD VARCHAR(15) FOREIGN KEY REFERENCES HoaDon(MaHD),
    MaSP VARCHAR(10) FOREIGN KEY REFERENCES SanPham(MaSP),
    SoLuongMua INT NOT NULL,
    ThanhTien FLOAT NOT NULL,
    PRIMARY KEY (MaHD, MaSP)
);
GO

-- 5. Thêm dữ liệu mẫu phong phú cho Menu Đồ Uống (12 món chuẩn quán Cafe / Trà sữa)
INSERT INTO SanPham (MaSP, TenSP, DonGia, SoLuong) VALUES
('DU01', N'Cà Phê Đen Đá', 25000, 100),
('DU02', N'Cà Phê Sữa Sài Gòn', 30000, 80),
('DU03', N'Bạc Xỉu Đá', 32000, 75),
('DU04', N'Trà Sữa Trân Châu Đường Đen', 45000, 60),
('DU05', N'Trà Sữa Thái Xanh', 38000, 55),
('DU06', N'Trà Đào Cam Sả', 35000, 70),
('DU07', N'Trà Vải Hoa Hồng', 38000, 50),
('DU08', N'Matcha Đá Xay Kem Cheese', 52000, 40),
('DU09', N'Sữa Tươi Trân Châu Nhật', 48000, 65),
('DU10', N'Hồng Trà Kem Mặn', 40000, 45),
('DU11', N'Nước Ép Cam Tươi', 35000, 50),
('DU12', N'Sinh Tố Bơ Sáp', 45000, 30);
GO

-- 6. Thêm vài hóa đơn mẫu để test thống kê
INSERT INTO HoaDon (MaHD, NgayLap, TongTien) VALUES
('HD001', '2026-11-18 08:30:00', 85000),
('HD002', '2026-11-18 14:15:00', 115000);
GO

INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuongMua, ThanhTien) VALUES
('HD001', 'DU01', 2, 50000),
('HD001', 'DU06', 1, 35000),
('HD002', 'DU04', 1, 45000),
('HD002', 'DU06', 2, 70000);
GO

-- Kiểm tra lại dữ liệu vừa tạo
SELECT * FROM SanPham;
SELECT * FROM HoaDon;
SELECT * FROM ChiTietHoaDon;
GO