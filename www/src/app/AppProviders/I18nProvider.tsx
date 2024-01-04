'use client'

import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import {AdapterMoment} from "@mui/x-date-pickers/AdapterMoment";
import {PropsWithChildren} from "react";

const I18nProvider = ({ children }: PropsWithChildren) => (
  <LocalizationProvider dateAdapter={AdapterMoment}>
    {children}
  </LocalizationProvider>
)

export default I18nProvider
