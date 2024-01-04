import I18nProvider from "./I18nProvider";
import {PropsWithChildren} from "react";


const AppProviders = ({ children }: PropsWithChildren) => (
  <I18nProvider>
    {children}
  </I18nProvider>
)

export default AppProviders
