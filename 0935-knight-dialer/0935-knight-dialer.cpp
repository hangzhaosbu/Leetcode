using VL = vector< long >;
using VVL = vector< VL >;
class Solution {
    static const int MOD = 1000000007;
public:
    int knightDialer( int N ){
        VVL dp( N+1, VL( 10, 1 ));
        for( int i{ 2 };  i <= N;  ++i ){
            dp[ i ][ 0 ] = (  dp[ i-1 ][ 4 ] + dp[ i-1 ][ 6 ]  ) % MOD;
            dp[ i ][ 1 ] = (  dp[ i-1 ][ 6 ] + dp[ i-1 ][ 8 ]  ) % MOD;
            dp[ i ][ 2 ] = (  dp[ i-1 ][ 7 ] + dp[ i-1 ][ 9 ]  ) % MOD;
            dp[ i ][ 3 ] = (  dp[ i-1 ][ 4 ] + dp[ i-1 ][ 8 ]  ) % MOD;
            dp[ i ][ 4 ] = (  dp[ i-1 ][ 0 ] + dp[ i-1 ][ 3 ] + dp[ i-1 ][ 9 ]  ) % MOD;
            dp[ i ][ 5 ] = (  0  );
            dp[ i ][ 6 ] = (  dp[ i-1 ][ 0 ] + dp[ i-1 ][ 1 ] + dp[ i-1 ][ 7 ]  ) % MOD;
            dp[ i ][ 7 ] = (  dp[ i-1 ][ 2 ] + dp[ i-1 ][ 6 ]  ) % MOD;
            dp[ i ][ 8 ] = (  dp[ i-1 ][ 1 ] + dp[ i-1 ][ 3 ]  ) % MOD;
            dp[ i ][ 9 ] = (  dp[ i-1 ][ 2 ] + dp[ i-1 ][ 4 ]  ) % MOD;
        }
        return accumulate( dp[ N ].begin(), dp[ N ].end(), 0L ) % MOD;
    }
};