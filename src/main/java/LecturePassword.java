import org.mindrot.jbcrypt.BCrypt;

public class LecturePassword {


    public static void main(String[] args) {
//        Additional Resources
//        http://cs.wellesley.edu/~cs304/lectures/bcrypt/dustwell.html
//        https://www.youtube.com/watch?v=sjEeqtZ7Tw4
//        https://www.youtube.com/watch?v=cczlpiiu42M





        /* ************** HASHING A PW ************** */
        String password = "helloworld";
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());

//        System.out.println("Plain text password is: " + password);
//        System.out.println("Hashed password is: " + hash);







        // Notice how when we hash the same string, the hash is different
        // Represents how when a user registers, we would take the plain text pw and store the hashed version of pw

        String password2 = "qwerty";

        String hash2 = BCrypt.hashpw(password2, BCrypt.gensalt());
//        System.out.println("HASH2: " + hash2);

        String hash3 = BCrypt.hashpw(password2, BCrypt.gensalt());
//        System.out.println("HASH3: " + hash3);

        String hash4 = BCrypt.hashpw(password2, BCrypt.gensalt());
//        System.out.println("HASH4: " + hash4);








        /* ************** VERIFYING A PW ************** */

        // represents a user logging in, we would take the password and compare it to the hashed pw in the db

        boolean pwMatch2 = BCrypt.checkpw("qwerty", hash2);
        System.out.println("PW Match 2: " + pwMatch2);



        boolean pwMatch3 = BCrypt.checkpw("qwerty", hash3);
        System.out.println("PW Match 3: " + pwMatch3);



//        //Notice here we have changed the password to check to admin
        boolean pwMatch4 = BCrypt.checkpw("admin", hash4);
        System.out.println("PW Match 4: " + pwMatch4);







        /* ************** INCREASING SALT ROUNDS ************** */
//        https://auth0.com/blog/hashing-in-action-understanding-bcrypt/
//        https://stackoverflow.com/questions/31470149/unable-to-understand-bcrypt-gensalt-in-bcrypt-npm-package


//        String password3 = "Jup1t3rRule$";
//        String hashedPw = BCrypt.hashpw(password3, BCrypt.gensalt());
//        String hashedPw2 = BCrypt.hashpw(password3, BCrypt.gensalt(12));
//        String hashedPw3 = BCrypt.hashpw(password3, BCrypt.gensalt(14));
//
//        System.out.println(hashedPw);
//        System.out.println(hashedPw2);
//        System.out.println(hashedPw3);


//		for (int saltRounds = 10; saltRounds < 18; saltRounds++) {
//			long startTime = System.nanoTime();
//
//			String hashedPw = BCrypt.hashpw("Jup1t3rRule$", BCrypt.gensalt(saltRounds));
//
//			long endTime = System.nanoTime();
//			long duration = (endTime - startTime);
//
//			 last one takes about 8 sec
//			System.out.println("bcrypt | salt: " + saltRounds + ".... time to hash: " + duration/1000000 + " ms | " + hashedPw); //divide by 1000000 for ms
//		}



        // Must hash passwords before saving to database
        // Do not hash passwords more than once
        // Checking the password should be in the login servlet
        // May do the hashing in the Model or Dao or Servlet (but only once)



        // ********* Mini Exercise *********
        //  (1) Hash a plain text password. For ex:
        //      String ex = "qwerty";
        //      String hashExample = BCrypt.hashpw(ex, BCrypt.gensalt());
        // (2) Compare plain text password to hashed password from step 1. Print results. For ex:
        //       boolean exMatch = BCrypt.checkpw("qwerty", hashExample);
        // (Bonus) Try increasing salt rounds. But be careful, not too many for your computer! I couldn't go over ~20




    }



}
