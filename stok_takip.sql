-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 04 May 2020, 19:12:48
-- Sunucu sürümü: 10.1.36-MariaDB
-- PHP Sürümü: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `stok_takip`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici_bilgileri`
--

CREATE TABLE `kullanici_bilgileri` (
  `id` int(11) NOT NULL,
  `kullanici_adi` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `kullanici_sifresi` varchar(15) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `kullanici_bilgileri`
--

INSERT INTO `kullanici_bilgileri` (`id`, `kullanici_adi`, `kullanici_sifresi`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `main`
--

CREATE TABLE `main` (
  `id` int(11) NOT NULL,
  `kullanici_bilgileri` int(11) DEFAULT NULL,
  `ürün_bilgileri` int(11) DEFAULT NULL,
  `satis_bilgileri` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `satislar`
--

CREATE TABLE `satislar` (
  `id` int(11) NOT NULL,
  `satilan_ürün` varchar(25) COLLATE utf8_turkish_ci NOT NULL,
  `satis_miktari` int(11) NOT NULL,
  `satis_tipi` varchar(15) COLLATE utf8_turkish_ci NOT NULL,
  `satis_tarihi` varchar(15) COLLATE utf8_turkish_ci NOT NULL,
  `satis_fiyati` int(11) DEFAULT NULL,
  `ürün_kari` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `satislar`
--

INSERT INTO `satislar` (`id`, `satilan_ürün`, `satis_miktari`, `satis_tipi`, `satis_tarihi`, `satis_fiyati`, `ürün_kari`) VALUES
(34, 'Persil 5 kg toz', 10, 'Nakit', '04/05/2020', 350, 100),
(35, 'Persil 5 kg toz 2', 3, 'Kredi Kart?', '04/05/2020', 111, 36),
(36, 'Persil 5 kg toz', 5, 'Nakit', '04/05/2020', 185, 60),
(37, 'Persil 5 kg toz 2', 4, 'Nakit', '04/05/2020', 148, 48);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ürünler`
--

CREATE TABLE `ürünler` (
  `id` int(11) NOT NULL,
  `Urun_Adi` varchar(65) COLLATE utf8_turkish_ci NOT NULL,
  `alis_fiyati` int(11) NOT NULL,
  `satis_fiyati` int(11) NOT NULL,
  `Urun_Turu` varchar(65) COLLATE utf8_turkish_ci NOT NULL,
  `stok_miktari` int(11) NOT NULL,
  `bolum` varchar(25) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `ürünler`
--

INSERT INTO `ürünler` (`id`, `Urun_Adi`, `alis_fiyati`, `satis_fiyati`, `Urun_Turu`, `stok_miktari`, `bolum`) VALUES
(22, 'Persil 5 kg toz', 25, 37, 'Deterjan', 35, '1. raf sol'),
(24, 'Persil 5 kg toz 2', 25, 37, 'Deterjan', 43, '1. raf sol'),
(25, 'Persil 1 kg s?v?', 13, 23, 'S?v? Deterjan', 44, '1. raf sol');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `kullanici_bilgileri`
--
ALTER TABLE `kullanici_bilgileri`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `kullanici_adi` (`kullanici_adi`),
  ADD UNIQUE KEY `kullanici_sifresi` (`kullanici_sifresi`);

--
-- Tablo için indeksler `main`
--
ALTER TABLE `main`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_kullanici` (`kullanici_bilgileri`),
  ADD KEY `fk_ürün` (`ürün_bilgileri`),
  ADD KEY `fk_satis` (`satis_bilgileri`);

--
-- Tablo için indeksler `satislar`
--
ALTER TABLE `satislar`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `ürünler`
--
ALTER TABLE `ürünler`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ürün_adi` (`Urun_Adi`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `kullanici_bilgileri`
--
ALTER TABLE `kullanici_bilgileri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `main`
--
ALTER TABLE `main`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `satislar`
--
ALTER TABLE `satislar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Tablo için AUTO_INCREMENT değeri `ürünler`
--
ALTER TABLE `ürünler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `main`
--
ALTER TABLE `main`
  ADD CONSTRAINT `fk_kullanici` FOREIGN KEY (`kullanici_bilgileri`) REFERENCES `kullanici_bilgileri` (`id`),
  ADD CONSTRAINT `fk_satis` FOREIGN KEY (`satis_bilgileri`) REFERENCES `satislar` (`id`),
  ADD CONSTRAINT `fk_ürün` FOREIGN KEY (`ürün_bilgileri`) REFERENCES `ürünler` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
