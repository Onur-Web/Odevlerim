package week1;

import java.util.Scanner;

public class BurcBulma {
    public static void main(String[] args) {

        int ay, gun;
        String burc = "";
        boolean isYanlis = false;

        Scanner input = new Scanner(System.in);

        System.out.print("Doğduğunuz Ay : ");
        ay = input.nextInt();

        System.out.print("Doğduğunuz Gün : ");
        gun = input.nextInt();

        if ((ay >= 1) && (ay <= 13)) {
            if (ay == 1) {
                if (gun >= 1 && gun <= 31) {
                    if (gun < 22) {
                        burc = "Oğlak";
                    } else {
                        burc = "Kova";
                    }
                } else {
                    isYanlis = true;
                }
            } else if (ay == 2) {
                if (gun >= 1 && gun <= 29) {
                    if (gun < 20) {
                        burc = "Kova";
                    } else {
                        burc = "Balık";
                    }
                } else {
                    isYanlis = true;
                }
            } else if (ay == 3) {
                if (gun >= 1 && gun <= 31) {
                    if (gun < 21) {
                        burc = "Balık";
                    } else {
                        burc = "Koç";
                    }
                } else {
                    isYanlis = true;
                }
            } else if (ay == 4) {
                if (gun >= 1 && gun <= 30) {
                    if (gun < 21) {
                        burc = "Koç";
                    } else {
                        burc = "Boğa";
                    }
                } else {
                    isYanlis = true;
                }
            } else if (ay == 5) {
                if (gun >= 1 && gun <= 31) {
                    if (gun < 22) {
                        burc = "Boğa";
                    } else {
                        burc = "İkizler";
                    }
                } else {
                    isYanlis = true;
                }
            } else if (ay == 6) {
                if (gun >= 1 && gun <= 30) {
                    if (gun < 23) {
                        burc = "İkizler";
                    } else {
                        burc = "Yengeç";
                    }
                } else {
                    isYanlis = true;
                }
            } else if (ay == 7) {
                if (gun >= 1 && gun <= 31) {
                    if (gun < 23) {
                        burc = "Yengeç";
                    } else {
                        burc = "Aslan";
                    }
                } else {
                    isYanlis = true;
                }
            } else if (ay == 8) {
                if (gun >= 1 && gun <= 31) {
                    if (gun < 23) {
                        burc = "Aslan";
                    } else {
                        burc = "Başak";
                    }
                } else {
                    isYanlis = true;
                }
            } else if (ay == 9) {
                if (gun >= 1 && gun <= 30) {
                    if (gun < 23) {
                        burc = "Başak";
                    } else {
                        burc = "Terazi";
                    }
                } else {
                    isYanlis = true;
                }
            } else if (ay == 10) {
                if (gun >= 1 && gun <= 31) {
                    if (gun < 23) {
                        burc = "Terazi";
                    } else {
                        burc = "Akrep";
                    }
                } else {
                    isYanlis = true;
                }
            } else if (ay == 11) {
                if (gun >= 1 && gun <= 30) {
                    if (gun < 22) {
                        burc = "Akrep";
                    } else {
                        burc = "Yay";
                    }
                } else {
                    isYanlis = true;
                }
            } else if (ay == 12) {
                if (gun >= 1 && gun <= 31) {
                    if (gun < 22) {
                        burc = "Yay";
                    } else {
                        burc = "Oğlak";
                    }
                } else {
                    isYanlis = true;
                }
            }
            if (isYanlis) {
                System.out.println("Hatalı Giriş Yaptınız!!!");
            } else {
                System.out.println("Burcunuz : " + burc);
            }
        } else {
            System.out.println("Hatalı Giriş Yaptınız");
        }
    }
}
