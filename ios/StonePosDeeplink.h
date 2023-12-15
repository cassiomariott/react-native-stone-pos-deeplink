
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNStonePosDeeplinkSpec.h"

@interface StonePosDeeplink : NSObject <NativeStonePosDeeplinkSpec>
#else
#import <React/RCTBridgeModule.h>

@interface StonePosDeeplink : NSObject <RCTBridgeModule>
#endif

@end
