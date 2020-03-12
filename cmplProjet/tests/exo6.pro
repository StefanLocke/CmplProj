programme exempprocs : 
const n = 10; var ent x, y, z ;
proc p fixe(ent y, t) mod (ent n)
var ent z ;
debut 
lire(z);
si z > 0 alors n := x + y + z; p(n,z)(y) fsi;
fin;{p}
proc t mod(ent u) 
var ent t;
debut 
lire(t);p(n,y+t)(u);
fin;{t}
debut
lire(x,y);t()(z);
fin{exempprocs}
 