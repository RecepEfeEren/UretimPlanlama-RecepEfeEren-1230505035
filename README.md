# İşlem Sürelerini Minimize Eden Program

## Açıklama

Bu Java programı, belirli işlerin belirli makinelerde minimum toplam süre ile tamamlanmasını hesaplayan bir çözüm sunar. Birden fazla iş ve makine ile çalışan bu program, işlerin makinelerde geçiş maliyetlerini ve iş sürelerini dikkate alarak, işleri minimum toplam süreyle tamamlama yolunu bulur.

## Problem Tanımı

- Her işin, her makinede belirli bir süresi vardır.
- Bir işten diğerine geçerken makine değişimi olursa, ekstra geçiş maliyeti oluşur.
- Amaç, tüm işleri tamamlamak için gereken minimum toplam süreyi bulmaktır.

## Kullanılan Yapılar ve Fonksiyonlar

### Veri Yapıları

- **sureler[n][m]:**  
  n iş, m makine için iş sürelerini tutar.  
  `sureler[i][j]`: i numaralı işin j numaralı makinadaki süresi.

- **gecisMaliyet[m][m]:**  
  Bir makineden diğerine geçişteki ekstra maliyetleri tutar.  
  `gecisMaliyet[i][j]`: i makinesinden j makinesine geçiş süresi.

- **dp[n][m]:**  
  Dynamic Programming (DP) tablosu.  
  `dp[is][makine]`: is numaralı iş, makinede başlayınca gereken minimum toplam süreyi kaydeder.

### Ana Fonksiyonlar

- **minToplamSure(int is, int makine):**  
  Rekürsif olarak çalışır.  
  `is` numaralı iş ve `makine` seçimi için minimum süreyi hesaplar. Hesaplanan süreler `dp` tablosuna kaydedilir (memorization).  
  Eğer `dp[is][makine]` zaten hesaplandıysa, bu değeri direkt döndürür.  
  İşler bittiğinde (is == n olduğunda) 0 döner (iş kalmadı).

- **main:**  
  - `sureler` ve `gecisMaliyet` matrislerini örnek verilerle başlatır.  
  - `dp` tablosu tamamen -1 ile doldurulur (Arrays.fill() ile).  
  - Tüm makineler için ilk işten başlayarak minimum süre hesaplanır.  
  - Minimum süre ekrana yazdırılır.

## Proje Nasıl Çalışır?

1. Tüm işler ve makineler tanımlanır.
2. Dynamic Programming ile minimum süreler hesaplanır.
3. En küçük toplam süre bulunur ve yazdırılır.

## Örnek Çıktı

Minimum toplam süre: 17

## Hazırlayan

Recep Efe Eren 1230505035
