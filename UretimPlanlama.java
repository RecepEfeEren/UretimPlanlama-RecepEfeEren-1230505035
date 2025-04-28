import java.util.Arrays;

public class UretimPlanlama {
    static int[][] sureler;       // Her iş için her makinedeki süreler
    static int[][] gecisMaliyet;  // Makine geçiş maliyetleri
    static int[][] dp;            // Dinamik programlama tablosu

    //indeks değerleri
    static int minToplamSure(int is, int makine) {
        int n = sureler.length;   // İş sayısı
        int m = sureler[0].length; // Makine sayısı

        if (is == n) {
            return 0; // Tüm işler bitti
        }

        if (dp[is][makine] != -1) {
            return dp[is][makine]; // Daha önce hesaplandıysa kullan
        }

        int minSure = Integer.MAX_VALUE;

        for (int sonrakiMakine = 0; sonrakiMakine < m; sonrakiMakine++) {
            int gecis = (is == 0) ? 0 : gecisMaliyet[makine][sonrakiMakine];
            int toplam = sureler[is][sonrakiMakine] + gecis + minToplamSure(is + 1, sonrakiMakine);
            minSure = Math.min(minSure, toplam);
        }

        dp[is][makine] = minSure;
        return minSure;
    }

    public static void main(String[] args) {
        // Örnek veriler
        sureler = new int[][] {
            {5, 7, 6},   // İş 0 için her makinedeki süreler
            {8, 5, 7},   // İş 1 için her makinedeki süreler
            {6, 6, 4}    // İş 2 için her makinedeki süreler
        };

        gecisMaliyet = new int[][] {
            {0, 2, 3},
            {2, 0, 2},
            {3, 2, 0}
        };

        int n = sureler.length;
        int m = sureler[0].length;
        dp = new int[n][m];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int minToplam = Integer.MAX_VALUE;
        for (int makine = 0; makine < m; makine++) {
            minToplam = Math.min(minToplam, minToplamSure(0, makine));
        }

        System.out.println("Minimum toplam süre: " + minToplam);
    }
}
