#import <Foundation/Foundation.h>
#include "com/sfeir/calc/CalcEngine.h"
#include "com/sfeir/calc/CalcEngineImpl.h"

int main (int argc, const char * argv[]) {

    @autoreleasepool {

        id<ComSfeirCalcCalcEngine> calcEngine = [[ComSfeirCalcCalcEngineImpl alloc] init];

        printf ("insert expression...\n");

        char str[50] = {0};

        scanf("%s", str);

        NSString *expr = [NSString stringWithUTF8String:str];

        int result = [calcEngine evaluateWithNSString:expr];

        printf("%s = %i\n", str, result);
    }

    return 0;
}