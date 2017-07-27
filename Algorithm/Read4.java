/*
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
*/
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        
        
        char[] buf4 = new char[4];
        int index = 0;
        
        while(true){
            int curr = read4(buf4);
            
            for(int i = 0; i < curr && index < n; i++){
                buf[index++] = buf4[i];
            }
            
            if (curr == 0 || index == n) {
                return index;
            }
        }

    }
}

/*
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Note:
The read function may be called multiple times.
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    private char[] buf4 = new char[4];
    
    private int buf4Size = 4;
    
    private int buf4Index = 4;
     
    public int read(char[] buf, int n) {
        
        for(int i = 0; i < n; i++){
            if(!isValid(buf, i)){
                return i;
            }
        }
        
        return n;
    }
    
    private boolean isValid(char[] buf, int index){
        
        if(buf4Index == buf4Size){
            buf4Index = 0;
            buf4Size = read4(buf4);
            
            if(buf4Size == 0){
                return false;
            }
        }
        
        buf[index] = buf4[buf4Index++];
        return true;
    }
}


public class Read4 {


    private int read(char[] buff, int index) {
        return 0;
    }


    private char[] buf1024 = new char[1024];
    private int index = 0;


    private int buf1024Size = 0;
    private int buf1024Index = 0;

    public int helper(char[] buf, int n) {


        while (true) {

            int curr = read(buf1024, index);


            for (int i = 0; i < curr && index < n; i++) {

                buf[index++] = buf1024[i++];
                index = i;
            }
            if (curr == 0 || index == n) {
                return index;
            }

        }


    }


    private int helper2(char[] buf, int n) {


        for (int i = 0; i < n; i++) {

            if (!isValid(buf, i)) {

                return i;
            }


        }

        return n;
    }


    private boolean isValid(char[] buf, int index) {

        if (buf1024Index == buf1024Size) {


            buf1024Index = 0;
            buf1024Size = read(buf1024, index);


            if (buf1024Size == 0) {

                return false;
            }
        }


        buf[index] = buf1024[buf1024Index++];
        return true;

    }
}


