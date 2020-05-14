import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//NOT WORKING RN, THE FIRST NUMBER IS NUM OF PIZZAS OF TYPE REST OF LINE
public class prob20
{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        int pepperoni=0,redPeppers=0,pinapple=0,olives=0,sardines=0,onion=0,sausage=0,ham=0;
        while(sc.hasNextLine())
        {
            String yeetus = sc.nextLine();
            String[] whyTho = yeetus.split(" & ");
            for(String g:whyTho)
            {
                String[] f = g.split(" ");
                if(f.length == 2 || (f.length == 3 && f[1].equals("Red")))
                {
                    if(f[0].length() == 1)
                    {
                        if(f[1].equals("Pepperoni"))
                        {
                            pepperoni+=32*Integer.parseInt(f[0]);
                        }
                        else if(f[1].equals("Red"))
                        {
                            redPeppers+=16*Integer.parseInt(f[0]);
                        }
                        else if(f[1].equals("Pineapple"))
                        {
                            pinapple+=84*Integer.parseInt(f[0]);
                        }
                        else if(f[1].equals("Olives"))
                        {
                            olives+=20*Integer.parseInt(f[0]);
                        }
                        else if(f[1].equals("Sardines"))
                        {
                            sardines+=12*Integer.parseInt(f[0]);
                        }
                        else if(f[1].equals("Onion"))
                        {
                            onion+=28*Integer.parseInt(f[0]);
                        }
                        else if(f[1].equals("Sausage"))
                        {
                            sausage+=40*Integer.parseInt(f[0]);
                        }
                        else if(f[1].equals("Ham"))
                        {
                            ham+=36*Integer.parseInt(f[0]);
                        }
                        else if(f[1].equals("Meat-Lovers"))
                        {
                            sausage+=40*Integer.parseInt(f[0]);
                            ham+=36*Integer.parseInt(f[0]);
                            pepperoni+=32*Integer.parseInt(f[0]);
                        }
                        else if(f[1].equals("Hawaiian"))
                        {
                            pinapple+=84*Integer.parseInt(f[0]);
                            ham+=36*Integer.parseInt(f[0]);
                        }
                        else if(f[1].equals("Combo"))
                        {
                            redPeppers+=16*Integer.parseInt(f[0]);
                            olives+=20*Integer.parseInt(f[0]);
                            onion+=28*Integer.parseInt(f[0]);
                            sausage+=40*Integer.parseInt(f[0]);
                        }
                        else if(f[1].equals("Fishaster"))
                        {
                            sardines+=12*Integer.parseInt(f[0]);
                            onion+=28*Integer.parseInt(f[0]);
                        }
                    }
                    else if(Integer.parseInt(f[0].substring(2))==2)
                    {
                        if(f[1].equals("Pepperoni"))
                        {
                            pepperoni+=16;
                        }
                        else if(f[1].equals("Red"))
                        {
                            redPeppers+=8;
                        }
                        else if(f[1].equals("Pineapple"))
                        {
                            pinapple+=42;
                        }
                        else if(f[1].equals("Olives"))
                        {
                            olives+=10;
                        }
                        else if(f[1].equals("Sardines"))
                        {
                            sardines+=6;
                        }
                        else if(f[1].equals("Onion"))
                        {
                            onion+=14;
                        }
                        else if(f[1].equals("Sausage"))
                        {
                            sausage+=20;
                        }
                        else if(f[1].equals("Ham"))
                        {
                            ham+=18;
                        }
                        else if(f[1].equals("Meat-Lovers"))
                        {
                            sausage+=20;
                            ham+=18;
                            pepperoni+=16;
                        }
                        else if(f[1].equals("Hawaiian"))
                        {
                            pinapple+=42;
                            ham+=18;
                        }
                        else if(f[1].equals("Combo"))
                        {
                            redPeppers+=8;
                            olives+=10;
                            onion+=14;
                            sausage+=20;
                        }
                        else if(f[1].equals("Fishaster"))
                        {
                            sardines+=6;
                            onion+=14;
                        }
                    }
                    else if(Integer.parseInt(f[0].substring(2))==4)
                    {
                        if(f[1].equals("Pepperoni"))
                        {
                            pepperoni+=8;
                        }
                        else if(f[1].equals("Red"))
                        {
                            redPeppers+=4;
                        }
                        else if(f[1].equals("Pineapple"))
                        {
                            pinapple+=21;
                        }
                        else if(f[1].equals("Olives"))
                        {
                            olives+=5;
                        }
                        else if(f[1].equals("Sardines"))
                        {
                            sardines+=3;
                        }
                        else if(f[1].equals("Onion"))
                        {
                            onion+=7;
                        }
                        else if(f[1].equals("Sausage"))
                        {
                            sausage+=10;
                        }
                        else if(f[1].equals("Ham"))
                        {
                            ham+=9;
                        }
                        else if(f[1].equals("Meat-Lovers"))
                        {
                            sausage+=10;
                            ham+=9;
                            pepperoni+=8;
                        }
                        else if(f[1].equals("Hawaiian"))
                        {
                            pinapple+=21;
                            ham+=9;
                        }
                        else if(f[1].equals("Combo"))
                        {
                            redPeppers+=4;
                            olives+=5;
                            onion+=7;
                            sausage+=10;
                        }
                        else if(f[1].equals("Fishaster"))
                        {
                            sardines+=3;
                            onion+=7;
                        }
                    }
                }
                else
                {
                    if(f[2].equals("Pepperoni"))
                    {
                        pepperoni+=32*Integer.parseInt(f[0]);
                    }
                    else if(f[2].equals("Red"))
                    {
                        redPeppers+=16*Integer.parseInt(f[0]);
                    }
                    else if(f[2].equals("Pineapple"))
                    {
                        pinapple+=84*Integer.parseInt(f[0]);
                    }
                    else if(f[2].equals("Olives"))
                    {
                        olives+=20*Integer.parseInt(f[0]);
                    }
                    else if(f[2].equals("Sardines"))
                    {
                        sardines+=12*Integer.parseInt(f[0]);
                    }
                    else if(f[2].equals("Onion"))
                    {
                        onion+=28*Integer.parseInt(f[0]);
                    }
                    else if(f[2].equals("Sausage"))
                    {
                        sausage+=40*Integer.parseInt(f[0]);
                    }
                    else if(f[2].equals("Ham"))
                    {
                        ham+=36*Integer.parseInt(f[0]);
                    }
                    else if(f[2].equals("Meat-Lovers"))
                    {
                        sausage+=40*Integer.parseInt(f[0]);
                        ham+=36*Integer.parseInt(f[0]);
                        pepperoni+=32*Integer.parseInt(f[0]);
                    }
                    else if(f[2].equals("Hawaiian"))
                    {
                        pinapple+=84*Integer.parseInt(f[0]);
                        ham+=36*Integer.parseInt(f[0]);
                    }
                    else if(f[2].equals("Combo"))
                    {
                        redPeppers+=16*Integer.parseInt(f[0]);
                        olives+=20*Integer.parseInt(f[0]);
                        onion+=28*Integer.parseInt(f[0]);
                        sausage+=40*Integer.parseInt(f[0]);
                    }
                    else if(f[2].equals("Fishaster"))
                    {
                        sardines+=12*Integer.parseInt(f[0]);
                        onion+=28*Integer.parseInt(f[0]);
                    }
                    if(Integer.parseInt(f[1].substring(2))==2)
                    {
                        if(f[2].equals("Pepperoni"))
                        {
                            pepperoni+=16;
                        }
                        else if(f[2].equals("Red"))
                        {
                            redPeppers+=8;
                        }
                        else if(f[2].equals("Pineapple"))
                        {
                            pinapple+=42;
                        }
                        else if(f[2].equals("Olives"))
                        {
                            olives+=10;
                        }
                        else if(f[2].equals("Sardines"))
                        {
                            sardines+=6;
                        }
                        else if(f[2].equals("Onion"))
                        {
                            onion+=14;
                        }
                        else if(f[2].equals("Sausage"))
                        {
                            sausage+=20;
                        }
                        else if(f[2].equals("Ham"))
                        {
                            ham+=18;
                        }
                        else if(f[2].equals("Meat-Lovers"))
                        {
                            sausage+=20;
                            ham+=18;
                            pepperoni+=16;
                        }
                        else if(f[2].equals("Hawaiian"))
                        {
                            pinapple+=42;
                            ham+=18;
                        }
                        else if(f[2].equals("Combo"))
                        {
                            redPeppers+=8;
                            olives+=10;
                            onion+=14;
                            sausage+=20;
                        }
                        else if(f[2].equals("Fishaster"))
                        {
                            sardines+=6;
                            onion+=14;
                        }
                    }
                    else if(Integer.parseInt(f[1].substring(2))==4)
                    {
                        if(f[2].equals("Pepperoni"))
                        {
                            pepperoni+=8;
                        }
                        else if(f[2].equals("Red"))
                        {
                            redPeppers+=4;
                        }
                        else if(f[2].equals("Pineapple"))
                        {
                            pinapple+=21;
                        }
                        else if(f[2].equals("Olives"))
                        {
                            olives+=5;
                        }
                        else if(f[2].equals("Sardines"))
                        {
                            sardines+=3;
                        }
                        else if(f[2].equals("Onion"))
                        {
                            onion+=7;
                        }
                        else if(f[2].equals("Sausage"))
                        {
                            sausage+=10;
                        }
                        else if(f[2].equals("Ham"))
                        {
                            ham+=9;
                        }
                        else if(f[2].equals("Meat-Lovers"))
                        {
                            sausage+=10;
                            ham+=9;
                            pepperoni+=8;
                        }
                        else if(f[2].equals("Hawaiian"))
                        {
                            pinapple+=21;
                            ham+=9;
                        }
                        else if(f[2].equals("Combo"))
                        {
                            redPeppers+=4;
                            olives+=5;
                            onion+=7;
                            sausage+=10;
                        }
                        else if(f[2].equals("Fishaster"))
                        {
                            sardines+=3;
                            onion+=7;
                        }
                    }
                }
                System.out.println(pepperoni + " " +redPeppers + " " +pinapple + " " +olives + " " +sardines + " " +onion + " " +sausage + " " + ham);
            }
        }
        System.out.println(pepperoni + " " +redPeppers + " " +pinapple + " " +olives + " " +sardines + " " +onion + " " +sausage + " " + ham);
    }
}
