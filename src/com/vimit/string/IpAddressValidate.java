package com.vimit.string;

public class IpAddressValidate {


        public static void main(String[] args) {
            System.out.println(validateIP("0.0.0.0.3453.43534"));
        }


        static boolean validateIP(String ip) {
            String[] arr = ip.split("\\.", 5);
            if (arr.length != 4) {
                return false;
            }

            for (int i = 0; i < arr.length; i++) {
                int value = -1;
                try {
                    value = Integer.parseInt(arr[i]);
                } catch (Exception e) {
                    value = -1;
                }

                if (value < 0 || value > 255) return false;
            }

            return true;
        }

}
