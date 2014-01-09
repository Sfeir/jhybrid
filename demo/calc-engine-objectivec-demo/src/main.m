#import <Foundation/Foundation.h>
#include "build/CalcEngine.h"
#include "build/CalcEngineImpl.h"
#include "build/CalcMain.h"

int main (int argc, const char * argv[]) {

    @autoreleasepool {

        id<CalcEngine> calcEngine = [[CalcEngineImpl alloc] init];

        printf ("insert expression...\n");

        char str[50] = {0};

        scanf("%s", str);

        NSString *expr = [NSString stringWithUTF8String:str];

        int result = [calcEngine evaluateWithNSString:expr];

        printf("%s = %i\n", str, result);
    }

    return 0;
}